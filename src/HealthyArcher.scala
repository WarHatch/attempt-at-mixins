import helpers.Vector2

class HealthyArcher(var _health: Int,
                    var _position: Vector2,
                   ) extends Warrior(_health, _position) with healthyBonus with legsAndSword {
  val stepSize: Float = 1
  val damage: Int = 2
  val range: Int = 10

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
}
