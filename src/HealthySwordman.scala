import Main.{Warrior, legsAndSword, healthyPrayer}

class HealthySwordsman(var _health: Int,
                       var _position: Vector2,
                      ) extends Warrior(_health, _position) with healthyPrayer with legsAndSword {
  val stepSize: Float = 1
  val damage: Int = 5
}