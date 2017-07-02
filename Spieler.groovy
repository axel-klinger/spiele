class Spieler {

  Random random = new Random()
  def hand = []

  def spielen() {
    def karte = hand.get(random.nextInt(hand.size()))
    hand = hand - karte
    return karte
  }
}
