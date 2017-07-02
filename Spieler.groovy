class Spieler {

  Random random = new Random()
  def hand = []
  def stapel = []

  def spielen(tisch) {
    if (tisch.size() == 0) {
      hand.remove(hand.size() - 1)
    } else {
      hand.remove(random.nextInt(hand.size()))
    }
  }
}
