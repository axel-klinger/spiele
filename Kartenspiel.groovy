

class Kartenspiel {
  static blatt = ["Herz 7", "Herz 8", "Herz 9", "Herz 10", "Herz Bube", "Herz Dame", "Herz König", "Herz Ass",
               "Karo 7", "Karo 8", "Karo 9", "Karo 10", "Karo Bube", "Karo Dame", "Karo König", "Karo Ass",
               "Kreuz 7", "Kreuz 8", "Kreuz 9", "Kreuz 10", "Kreuz Bube", "Kreuz Dame", "Kreuz König", "Kreuz Ass",
               "Pik 7", "Pik 8", "Pik 9", "Pik 10", "Pik Bube", "Pik Dame", "Pik König", "Pik Ass"]

  static spieler1 = []
  static spieler2 = []
  static spieler3 = []

  static Random random = new Random()

  static ziehen() {
    def karte = blatt.get(random.nextInt(blatt.size()))
    blatt = blatt - karte
    return karte
  }

  static geben() {
    10.times {
      spieler1 << ziehen()
      spieler2 << ziehen()
      spieler3 << ziehen()
    }
  }

  static spielen(spieler) {
    def karte = spieler.get(random.nextInt(spieler.size()))
    spieler = spieler - karte
    return karte
  }

  static main(args) {

    geben()
    println "Spieler 1: " + spieler1.sort()
    println "Spieler 2: " + spieler2.sort()
    println "Spieler 3: " + spieler3.sort()
    println "Blatt: " + blatt.sort()

    // spielen
    10.times {
      def tisch = []
      tisch << spielen(spieler1)
      tisch << spielen(spieler2)
      tisch << spielen(spieler3)
      println tisch
    }

    println "Spieler 1: " + spieler1.sort()
    println "Spieler 2: " + spieler2.sort()
    println "Spieler 3: " + spieler3.sort()
  }
}
