(ns divide.util)

;; ls '|' | sed 's/^/"/;s/$/"/' > 1.txt 
(def file_names [
"Allan.png"
"Allerta.png"
"Allerta Stencil.png"
"Amaranth.png"
"Annie Use Your Telescope.png"
"Anonymous Pro.png"
"Anton.png"
"Architects Daughter.png"
"Arimo.png"
"Artifica.png"
"Arvo.png"
"Asset.png"
"Astloth.png"
"Bangers.png"
"Bentham.png"
"Bevan.png"
"Bigshot One.png"
"Bowlby One.png"
"Bowlby One SC.png"
"Brawler.png"
"Buda 300.png"
"Cabin.png"
"Calligraffitti.png"
"Candal.png"
"Cantarell.png"
"Cardo.png"
"Carter One.png"
"Caudex.png"
"Cedarville 1.png"
"Cherry Cream Soda.png"
"Chewy.png"
"Coda.png"
"Coming soon.png"
"Copse.png"
"Corben 700.png"
"Cousine.png"
"Covered by your grace.png"
"Crafty Girls.png"
"Crimson Text.png"
"Crushed.png"
"Cuprum.png"
"Damion.png"
"Dancing Script.png"
"Dawning of a new day.png"
"Didact Gothic.png"
"Droid Sans Mono.png"
"Droid Sans.png"
"Droid Serif.png"
"EB Garamond.png"
"Expletus Sans.png"
"Fontdine swanky.png"
"Forum.png"
"Francois One.png"
"Geo.png"
"Give you glory.png"
"Goblin One.png"
"Goudy Booksetter.png"
"Gravitas One.png"
"Gruppo.png"
"Hammersmith One.png"
"Holtwood One SC.png"
"Homemade apple pie.png"
"Im Fell Double Pica SC.png"
"Im fell DW Double Pica.png"
"Im fell DW pica.png"
"Im fell DW Pica SC.png"
"Im Fell English.png"
"Im Fell English SC.png"
"Im Fell French Canon.png"
"Im Fell French Canon SC.png"
"Im Fell Great Primer.png"
"Im Fell Great Primer SC.png"
"Inconsolata"
"Indie Flower.png"
"Irish Grover.png"
"Irish Growler.png"
"Istok Web.png"
"Josefin Sins.png"
"Josefin Slab.png"
"Judson.png"
"Jura 500.png"
"Jura 600.png"
"Jura.png"
"Just another hand.png"
"Just me again down here.png"
"Kameron.png"
"Kenia.png"
"Kranky.png"
"Kreon.png"
"Kristi not bold.png"
"Kristi.png"
"La Belle Aurore.png"
"Lato 100 Italic.png"
"Lato 100.png"
"Lato 300.png"
"Lato 900 Bold.png"
"Lato 900.png"
"Lato Bold.png"
"Lato .png"
"League Script.png"
"Lekton.png"
"Limelight.png"
"Lobster.png"
"Lobster Two.png"
"Lora.png"
"Loved by the king.png"
"Love ya like a sister.png"
"Luckiest Guy.png"
"Maiden Orange.png"
"Mako.png"
"Maven Pro 700.png"
"Maven Pro 900.png"
"Maven Pro.png"
"Meddon.png"
"Medieval Sharp.png"
"Megrim.png"
"Merriweather.png"
"Metrophobic.png"
"Michroma.png"
"Miltonian.png"
"Miltonian Tattoo.png"
"Modern Antiqua.png"
"Molengo.png"
"Monofett.png"
"Mountains of Christmas.png"
"Muli 300.png"
"Muli.png"
"Neucha.png"
"Neuton.png"
"News Cycle.png"
"Nixie One.png"
"Nobile.png"
"Noca flat.png"
"Nova Cut.png"
"Nova mono.png"
"Nova oval.png"
"Nova round.png"
"Nova script.png"
"Nova Slim.png"
"Nova Square.png"
"Nunito Light.png"
"Nunito.png"
"OFL Sorts Mill Goudy TT.png"
"Old Standard TT.png"
"Open Sans 300.png"
"Open Sans 600.png"
"Open Sans 800.png"
"Open Sans condensed.png"
"Open Sans.png"
"Orbitron 500.png"
"Orbitron 700.png"
"Orbitron.png"
"Oswald.png"
"Over the rainbow.png"
"Pacifico.png"
"Patrick Hand.png"
"Paytone One.png"
"Permanent Marker.png"
"Philosopher.png"
"Playfair Display.png"
"Play.png"
"Podkova.png"
"PT Sans Narrow Bold.png"
"PT Sans Narrow.png"
"PT Sans.png"
"PT Serif Caption.png"
"PT Serif.png"
"Puritan.png"
"Quattrocento.png"
"Quattrocento Sans.png"
"Radley.png"
"Raleway 100.png"
"Redressed.png"
"Reenie Beanie.png"
"Rocksalt.png"
"Rokkitt.png"
"Ruslan Display.png"
"Schoolbell.png"
"Shadows into light.png"
"Shanti.png"
"Sigmar One.png"
"Six caps.png"
"Slackey.png"
"Smythe.png"
"Snackey and moo moo.png"
"Sniglet 800.png"
"Special Elite.png"
"Stardos Stencil.png"
"Sue Ellen Francisco.png"
"Sunshiney.png"
"Syncopate.png"
"Tangerine.png"
"Tenor Sans.png"
"Terminal Dosis light.png"
"The girl next door.png"
"Tinos.png"
"Ubuntu.png"
"Ultra.png"
"Unifraftordoof bold.png"
"Unifraftor waguntia.png"
"Unkempt.png"
"Varela.png"
"Varela Round.png"
"Vibur.png"
"Vollkorn.png"
"VT323.png"
"Waiting for the sunrise.png"
"Wallpoet.png"
"Walter Turncoat.png"
"Wire One.png"
"Yanone kaffeesats 300.png"
"Yanone Kaffeesats 700.png"
"Yanone kaffeesats.png"
"Yaseva One.png"
"Zeyada.png"])

(def file_names2 [
"Aclonica.png"
"Allan.png"
"Allerta.png"
"Allerta Stencil.png"
"Amaranth.png"
"Annie use your telescope.png"
"Anonymous Pro.png"
"Anton.png"
"Architects Daughter.png"
"Arimo.png"
"Artifica.png"
"Arvo.png"
"Asset.png"
"Astloth.png"
"Bangers.png"
"Bentham.png"
"Bevan.png"
"Bigshot One.png"
"Bowlby ONe.png"
"Bowlby One SC.png"
"Brawler.png"
"Buda 300.png"
"Cabin Bold.png"
"Cabin.png"
"Calligraffitti.png"
"Cantarell.png"
"Cardo.png"
"Carter One.png"
"Caudex.png"
"Cdont know font 2.png"
"CDont know font.png"
"Cedarville 1.png"
"Cherry Cream Soda.png"
"Chewy.png"
"Corben 700.png"
"Cousine.png"
"Covered by your grace.png"
"Crafty Girls.png"
"Crimson text.png"
"Crushed.png"
"Cuprum.png"
"Damion.png"
"Dancing Script.png"
"Dawning of a new day.png"
"Didact Gothic.png"
"Droid Sans Mono.png"
"Droid Sans.png"
"Droid Serif.png"
"EB Garamond.png"
"Expletus Sans.png"
"Fontdine Swanky.png"
"Forum.png"
"Francois One.png"
"Geo.png"
"Give you glory.png"
"Goblin One.png"
"Goudy Booksetter.png"
"Gravitas ONe.png"
"Gruppo.png"
"Hammersmith One.png"
"Holtwood One SC.png"
"Home made apple pie.png"
"Im fell Double Pica SC.png"
"Im fell DW double Pica.png"
"Im fell DW pica.png"
"Im fell DW Pica SC.png"
"Im fell English .png"
"Im Fell English SC.png"
"Im Fell French Canon.png"
"Im fell Great Primer.png"
"Im fell great primer SC.png"
"Inconsolata.png"
"Indie Flower.png"
"Irish Grover.png"
"Irish Growler 2.png"
"Irish Growler.png"
"Istock web.png"
"Josefin Sins.png"
"Josefin Slab.png"
"Judson .png"
"Jura 500.png"
"Jura 600.png"
"Jura.png"
"Just another hand.png"
"Just me again down here.png"
"Kameron.png"
"Kenia.png"
"Kranky.png"
"Kreon.png"
"Kristi.png"
"Labelle Aurore.png"
"Lato 100 italic.png"
"Lato 100.png"
"Lato 300.png"
"Lato 900 bold.png"
"Lato 900.png"
"Lato Bold.png"
"Lato .png"
"League Script.png"
"Lekton.png"
"Limelight.png"
"Lobster.png"
"Lobster two.png"
"Lora.png"
"Love ya like a sister.png"
"Luckiest Guy bold.png"
"Luckiest guy.png"
"Mako.png"
"Maven Pro 799.png"
"Maven Pro 900.png"
"Maven Pro.png"
"Meddon.png"
"Medieval sharp.png"
"Megrim.png"
"Merriweather.png"
"Metrophobic.png"
"Meuli.png"
"Michroma.png"
"Miltonian.png"
"Miltonian tattoo.png"
"Modern Antiqua.png"
"Molengo.png"
"Monofett.png"
"Mountains of Christmas.png"
"Muli 300.png"
"Neucha.png"
"Neuton.png"
"News Cycle.png"
"Nixie One.png"
"Nobile.png"
"Noca flat.png"
"Nova cut.png"
"Nova Light.png"
"Nova mono.png"
"Nova oval.png"
"Nova round.png"
"Nova script.png"
"Nova silm.png"
"Nova square.png"
"Nunito.png"
"OFL Sorts Mill Goudy TT.png"
"Old standard TT.png"
"Open Sans 300.png"
"Open sans 600.png"
"Open Sans 800.png"
"Open Sans condensed.png"
"Open sans.png"
"Orbitron 500.png"
"Orbitron 700.png"
"Orbitron 900.png"
"Orbitron.png"
"Oswaldver the rainbow.png"
"Over the rainbowOrbitron 900.png"
"Pacifico.png"
"Patrick Hand.png"
"Paytone One.png"
"Permanent Marker.png"
"Philosopher.png"
"Playfair Display.png"
"Play.png"
"Podkova.png"
"PT Sans Narrow.png"
"PT Sans Narrow Regularbold.png"
"PT Sans.png"
"PT Serif Caption.png"
"PT Serif.png"
"Puritan.png"
"Quattrocento.png"
"Quattrocentro sans.png"
"Radley.png"
"Raleway.png"
"Redressed.png"
"Reenie Beanie.png"
"Rocksalt.png"
"Rokkit.png"
"Ruslan Display.png"
"Schoolbell.png"
"Shadows into light.png"
"Shanti.png"
"Sigmar One.png"
"Six Caps.png"
"Slackey.png"
"Smythe.png"
"Snackey and moo moo.png"
"Sniglet 800.png"
"Special Elite.png"
"Stardos Stencil.png"
"Sue Ellen Francisco.png"
"Sunshiney.png"
"Syncopate.png"
"Tangerine.png"
"Tenor Sans.png"
"Terminal Dosis Light.png"
"The Girl next door.png"
"Tinos.png"
"Ubuntu.png"
"Ultra.png"
"Unifrafturdoof bold.png"
"UnifratturWaguntia.png"
"Unkempt.png"
"Varela.png"
"Varela Round.png"
"Vibur.png"
"Vollkorn.png"
"VT323.png"
"Waiting for the sunrise.png"
"Wallpoet.png"
"Walter Turncoat.png"
"Wire ONe.png"
"Yanone Kafeesatz.png"
"Yanone Kaffeesatz 300.png"
"Yanone Kaffeesatz 400.png"
"Yanone Kaffeesatz 700.png"
"Yeseva One.png"
"Zeyada.png"
])

(defn foo-cljc [x]
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn in? 
  "true if coll contains elm"
  [coll elm]  
  (some #(= elm %) coll))

(defn get_new_ids [current_id_list total_number_ids]
  (current_id_list conj (

  ))
)