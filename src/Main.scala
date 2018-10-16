import helpers.Vector2

object Main extends App {
  val dummyWarrior = new HealthySwordsman(30, new Vector2(1, 2))


  var swordheal = new HealthySwordsman(100, new Vector2())
  swordheal.Pray
  swordheal.Pray
  swordheal.Pray
  swordheal.GetBonuses(swordheal)

  swordheal.Approach(swordheal, dummyWarrior)
  swordheal.Attack(swordheal, dummyWarrior)


  var healthyArcher = new HealthyArcher(100, new Vector2(1, 1))
  healthyArcher.Pray
  healthyArcher.Pray
  healthyArcher.Pray
  healthyArcher.GetBonuses(healthyArcher)

  healthyArcher.Approach(healthyArcher, dummyWarrior)
  healthyArcher.Attack(healthyArcher, dummyWarrior)

  var resurrectingCavalry = new ResurrectingCavalry(1, new Vector2(1, 1))
  for (i <- 1 to 10) {
    resurrectingCavalry.Pray
  }
  resurrectingCavalry.GetBonuses(resurrectingCavalry)

  resurrectingCavalry.Approach(resurrectingCavalry, dummyWarrior)
  resurrectingCavalry.Attack(resurrectingCavalry, dummyWarrior)
}
