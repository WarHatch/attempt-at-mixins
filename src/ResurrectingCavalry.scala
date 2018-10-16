import helpers.Vector2

class ResurrectingCavalry(var _health: Int,
                          var _position: Vector2,
                         ) extends Warrior(_health, _position) with resurrectBonus with legsAndSword {
  val stepSize: Float = 3
  val damage: Int = 4
  val range: Int = 1

  override def Approach(approacher: Warrior, target: Warrior): Unit = {
    if (position.dst(target.position) > range) {
      val addedVector = approacher.position.add(target.position)
      val oneStepInDirection = addedVector.nor.scl(stepSize)
      approacher.position = approacher.position.add(oneStepInDirection)
    }
    if (position.dst(target.position) < 2) {
      val addedVector = approacher.position.add(target.position)
      val oneStepInDirection = addedVector.nor.scl(stepSize * -1)
      approacher.position = approacher.position.add(oneStepInDirection)
    }
  }

  //TODO: this probably doesn't work
  override def Attack(attacker: Warrior, target: Warrior) {
    if (position.dst(target.position) <= range) {
      target.LoseHealth(damage)

      // Back off
      val addedVector = position.add(target.position)
      val oneStep = addedVector.nor.scl(-1 * stepSize)
      position = position.add(oneStep)
    }
  }
}
