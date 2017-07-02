

class Kartenspiel {
  static blatt = ["Herz 7", "Herz 8", "Herz 9", "Herz 10", "Herz Bube", "Herz Dame", "Herz König", "Herz Ass",
               "Karo 7", "Karo 8", "Karo 9", "Karo 10", "Karo Bube", "Karo Dame", "Karo König", "Karo Ass",
               "Kreuz 7", "Kreuz 8", "Kreuz 9", "Kreuz 10", "Kreuz Bube", "Kreuz Dame", "Kreuz König", "Kreuz Ass",
               "Pik 7", "Pik 8", "Pik 9", "Pik 10", "Pik Bube", "Pik Dame", "Pik König", "Pik Ass"]

  static Random random = new Random()

  static ziehen() {
    def karte = blatt.get(random.nextInt(blatt.size()))
    blatt = blatt - karte
    return karte
  }

  static geben(spieler1, spieler2, spieler3) {
    10.times {
      spieler1.hand << ziehen()
      spieler2.hand << ziehen()
      spieler3.hand << ziehen()
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
      tisch << spieler1.spielen()
      tisch << spieler2.spielen()
      tisch << spieler3.spielen()
      println tisch
    }

    println "Spieler 1: " + spieler1.hand.sort()
    println "Spieler 2: " + spieler2.hand.sort()
    println "Spieler 3: " + spieler3.hand.sort()
  }
}
