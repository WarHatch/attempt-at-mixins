

object Main extends App {

  val dummyWarrior = new HealthySwordsman(30, new Vector2(1, 2))
  var swordheal = new HealthySwordsman(100, new Vector2())

  trait legsAndSword {
    val stepSize: Float
    val damage: Int

    def Approach(approacher: Warrior, target: Warrior) {

      if (approacher.position.dst(target.position) > 1) {
        val addedVector = approacher.position.add(target.position)
        val oneStepInDirection = addedVector.nor.scl(stepSize)
        approacher.position = approacher.position.add(oneStepInDirection)
      }
    }

    def Attack(attacker: Warrior, target: Warrior) {
      if (attacker.position.dst(target.position) <= 1) target.LoseHealth(damage)
    }
  }

  trait healthyPrayer {
    def GetBonuses(warrior: Warrior): Unit = {
      def pointThreshold: Int = 20

      if (warrior.pietyPoints >= pointThreshold) {
        warrior.pietyPoints = 0
        warrior.health += 10
      }
    }
  }

  swordheal.Pray
  swordheal.Pray
  swordheal.Pray
  swordheal.GetBonuses(swordheal)

  abstract class Warrior(var health: Int, var position: Vector2) {
    var pietyPoints: Int = 0

    def Pray {
      pietyPoints = pietyPoints + 10
    }

    def LoseHealth(damage: Int) {
      health -= damage
    }
  }

  swordheal.Approach(swordheal, dummyWarrior)
  swordheal.Attack(swordheal, dummyWarrior)
}
