import helpers.Vector2

abstract class Warrior(var health: Int, var position: Vector2) {
  var pietyPoints: Int = 0

  def Pray {
    pietyPoints = pietyPoints + 10
  }

  def LoseHealth(damage: Int) {
    health -= damage
  }
}