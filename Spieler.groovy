class Spieler {

  Random random = new Random()
  def hand = []

  def spielen() {
    hand.remove(random.nextInt(hand.size()))
  }
}
