

object Hello extends App {
  var swordheal = new HealthySwordsman(10, 0, new Vector2())

  trait legsAndSword {
    def stepSize: Float

    def damage: Int

    def position: Int

    def Approach(target: Warrior) {
      println("Approach!")
    }

    def Attack(target: Warrior) {
      println("Attack!")
    }
  }

  trait pious {
    var pointThreshold: Int

    def GetBonuses()
  }

  abstract class Warrior(var health: Int, var pietyPoints: Int, var position: Vector2) {
    def Pray {
      pietyPoints = pietyPoints + 5
    }

    def LoseHealth(damage: Int) {
      health -= damage
    }
  }

  class HealthySwordsman(
                          health: Int,
                          pietyPoints: Int,
                          position: Vector2,
                          //    damage: Int,
                          //    stepSize: Float,
                        ) extends Warrior(health, pietyPoints, position) with pious {
    def GetBonuses(): Unit = {
      if (pietyPoints >= pointThreshold) {
        pietyPoints = 0
        health += 10
      }
    }

    def pointThreshold: Int = 20
  }

  swordheal.Pray
  swordheal.Pray
  swordheal.GetBonuses()
}
