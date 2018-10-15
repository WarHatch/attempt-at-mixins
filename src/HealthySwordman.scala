import helpers.Vector2

class HealthySwordsman(var _health: Int,
                       var _position: Vector2,
                      ) extends Warrior(_health, _position) with healthyBonus with legsAndSword {
  val stepSize: Float = 1
  val damage: Int = 5
  val range: Int = 1
}
