trait legsAndSword {
  val stepSize: Float
  val damage: Int
  val range: Int

  def Approach(approacher: Warrior, target: Warrior) {

    if (approacher.position.dst(target.position) > 1) {
      val addedVector = approacher.position.add(target.position)
      val oneStepInDirection = addedVector.nor.scl(stepSize)
      approacher.position = approacher.position.add(oneStepInDirection)
    }
  }

  def Attack(attacker: Warrior, target: Warrior) {
    if (attacker.position.dst(target.position) <= range) target.LoseHealth(damage)
  }
}