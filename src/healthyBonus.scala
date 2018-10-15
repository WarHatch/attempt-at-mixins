trait healthyBonus {
  def GetBonuses(warrior: Warrior): Unit = {
    if (warrior.pietyPoints >= pointThreshold) {
      warrior.pietyPoints = 0
      warrior.health += 10
    }
  }

  def pointThreshold: Int = 20
}
