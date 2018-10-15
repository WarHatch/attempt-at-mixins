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
}
