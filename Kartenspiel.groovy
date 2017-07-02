

class Kartenspiel {
  static blatt = ["Karo 7", "Karo 8", "Karo 9", "Karo 10", "Karo Bube", "Karo Dame", "Karo König", "Karo Ass",
                  "Herz 7", "Herz 8", "Herz 9", "Herz 10", "Herz Bube", "Herz Dame", "Herz König", "Herz Ass",
                  "Pik 7", "Pik 8", "Pik 9", "Pik 10", "Pik Bube", "Pik Dame", "Pik König", "Pik Ass",
                  "Kreuz 7", "Kreuz 8", "Kreuz 9", "Kreuz 10", "Kreuz Bube", "Kreuz Dame", "Kreuz König", "Kreuz Ass",
               ]

  static Random random = new Random()

  static ziehen() {
    blatt.remove(random.nextInt(blatt.size()))
  }

  static geben(spieler1, spieler2, spieler3) {
    10.times {
      spieler1.hand << ziehen()
      spieler2.hand << ziehen()
      spieler3.hand << ziehen()
    }
  }

  static hoechsteKarte(tisch) {
    // ohne trumpf die höchste karte der ausgespielten "farbe"
    def highKarte = null
    tisch.eachWithIndex { karte, index ->
      if (highKarte == null) {
        highKarte = karte
      } else {
        highKarte = hoechsteKarte(highKarte, karte)
      }
    }
    return highKarte
  }

  static hoechsteKarte(karte1, karte2) {
    if (karte1.split(" ")[0] != karte2.split(" ")[0]) {
      return karte1
    } else if (karte1.split(" ")[1] > karte2.split(" ")[1]) {
      return karte1
    } else {
      return karte2
    }
  }

  static main(args) {

    Spieler spieler1 = new Spieler()
    Spieler spieler2 = new Spieler()
    Spieler spieler3 = new Spieler()

    geben(spieler1, spieler2, spieler3)
    println "Spieler 1: " + spieler1.hand.sort()
    println "Spieler 2: " + spieler2.hand.sort()
    println "Spieler 3: " + spieler3.hand.sort()
    println "Blatt: " + blatt.sort()

    // spielen
    10.times {
      def tisch = []
      tisch << spieler1.spielen(tisch)
      tisch << spieler2.spielen(tisch)
      tisch << spieler3.spielen(tisch)
      println tisch
      def index = hoechsteKarte(tisch)
      println index
    }

    println "Spieler 1: " + spieler1.hand.sort()
    println "Spieler 2: " + spieler2.hand.sort()
    println "Spieler 3: " + spieler3.hand.sort()
  }
}
