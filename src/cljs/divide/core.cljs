(ns divide.core
  (:require
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [reagent.session :as session]
   [reitit.frontend :as reitit]
   [clerk.core :as clerk]
   [accountant.core :as accountant]
   [divide.util]
   [clojure.set :as set]
   ))


(def total_id_list (reagent/atom (set (range 0 (count divide.util/file_names)))))
(def total_id_list2 (reagent/atom (set (range 0 (count divide.util/file_names2)))))
(def current_id_list (reagent/atom (set [0 1])))
(def current_id_list2 (reagent/atom (set [0 1])))
(def id1_ (reagent/atom 0))
(def id2_ (reagent/atom 1))

;; -------------------------
;; Routes

(def router
  (reitit/router
   [["/" :index]
    ["/about" :about]]))

(defn path-for [route & [params]]
  (if params
    (:path (reitit/match-by-name router route params))
    (:path (reitit/match-by-name router route))))

(defn new-id [current-ids-set all-ids-set]
  (let [available-ids (set/difference all-ids-set current-ids-set)]
    (nth (into [] available-ids) (rand-int (count available-ids))))
)

(defn on-divider-click [event]
  (js/console.log "Handling event" (str @current_id_list))
  (reset! id1_ (new-id @current_id_list @total_id_list))
  (reset! current_id_list (set/union (set [@id1_]) @current_id_list))
  (reset! id2_ (new-id @current_id_list @total_id_list))
  (reset! current_id_list (set/union (set [@id2_]) @current_id_list))
)

(defn on-divider-click2 [event]
  (js/console.log "Handling event" (str @current_id_list2))
  (reset! id1_ (new-id @current_id_list2 @total_id_list2))
  (reset! current_id_list2 (set/union (set [@id1_]) @current_id_list2))
  (reset! id2_ (new-id @current_id_list2 @total_id_list2))
  (reset! current_id_list2 (set/union (set [@id2_]) @current_id_list2))
)

(defn reset-dividers [_]
  (reset! id1_ 0)
  (reset! id2_ 1)
  (reset! current_id_list (set [0 1]))
  (reset! current_id_list2 (set [0 1]))
)

;; -------------------------
;; Page components

(defn about-page []
   [:span.main
    [:h1 "About example"]]) 

(defn image-compare []
  ;; Need to @ ref number_ids and id_list otherwise it's too lazy..
  (if (>= (+ (count @current_id_list) 1) (count @total_id_list))
    (do 
      (if (>= (+ (count @current_id_list2) 1) (count @total_id_list2))
        (do
          (about-page))
        (do
          [:span.main
          [:div {:class "flex-container-row"}
            [:div {:class "flex-container-column"} 
              [:input {:type "image" :src (str "/images/2/" (nth divide.util/file_names2 @id1_)) :on-click on-divider-click2}]
              [:h5 (nth divide.util/file_names2 @id1_)]]
            [:div {:class "flex-container-column"}
              [:input {:type "image" :src (str "/images/2/" (nth divide.util/file_names2 @id2_)) :on-click on-divider-click2}]
              [:h5 (nth divide.util/file_names2 @id2_)]]]])))
    (do
      [:span.main
      [:div {:class "flex-container-row"}
        [:div {:class "flex-container-column"} 
          [:input {:type "image" :src (str "/images/1/" (nth divide.util/file_names @id1_)) :on-click on-divider-click}]
          [:h5 (nth divide.util/file_names @id1_)]]
        [:div {:class "flex-container-column"}
          [:input {:type "image" :src (str "/images/1/" (nth divide.util/file_names @id2_)) :on-click on-divider-click}]
          [:h5 (nth divide.util/file_names @id2_)]]]]))
)

(defn home-page []
  (fn []
    [:span.main
     (image-compare)]))


;; -------------------------
;; Translate routes -> page components

(defn page-for [route]
  (case route
    :index #'home-page
    :about #'about-page))


;; -------------------------
;; Page mounting component

(defn current-page []
  (fn []
    (let [page (:current-page (session/get :route))]
      [:div
       [:header
        [:p {:style {:color "red"}}  [:a {:href (path-for :index) :on-click reset-dividers}  "Home"] " | "
         [:a {:href (path-for :about)} "About divide"]]]
       [page]
       [:footer]])))

;; -------------------------
;; Initialize app

(defn mount-root []
  (rdom/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (clerk/initialize!)
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (let [match (reitit/match-by-path router path)
            current-page (:name (:data  match))
            route-params (:path-params match)]
        (reagent/after-render clerk/after-render!)
        (session/put! :route {:current-page (page-for current-page)
                              :route-params route-params})
        (clerk/navigate-page! path)
        ))
    :path-exists?
    (fn [path]
      (boolean (reitit/match-by-path router path)))})
  (accountant/dispatch-current!)
  (mount-root))

(defn ^:dev/after-load reload! []
  (mount-root))
