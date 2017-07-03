class Adventure {

  static karte = [["Meer1", "Meer2", "Insel2 NW", "Insel2 NO"],
               ["Insel1 NW", "Insel1 NO", "Insel2 SW", "Insel2 SO"],
               ["Insel1 SW", "Insel1 SO", "Meer3", "Meer4"]]

  static main(args) {

    // ausgabe der karte ...
    println "Karte"
    // ... zeilenweise
    karte.size().times { number ->
      println karte[number]
    }

  }
}
