trait resurrectBonus {
  def GetBonuses(warrior: Warrior): Unit = {
    if (warrior.pietyPoints >= pointThreshold) {
      warrior.health = 100
    }
  }

  def pointThreshold: Int = 20
}


