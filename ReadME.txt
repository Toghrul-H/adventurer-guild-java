# 🏹 Adventurer Guild – Fantasy Quest Simulator (Java, OOP, JUnit)

A fantasy-themed **Object-Oriented Adventure Simulator** where heroes embark on quests, fight monsters, and gain experience using different weapon types. The project demonstrates **inheritance, polymorphism, composition, state pattern usage, and JUnit testing**.

---

## ✅ Features
- **Adventurers** with stats, ranking & XP system
- **Weapons**: `Sword`, `Bow`, `Staff` — each overrides behavior via polymorphism
- **Quests** with multiple monsters and difficulty
- **Battle Simulation** (turn-based with durability, armor & attack logic)
- **State Pattern** with `WeaponLifeCycle` (NEW → USED → DAMAGED → BROKEN)
- **JUnit Tests** for core battle mechanics
- **Reads from files**: adventurers, quest definitions, monster sequences

---

## 📁 Project Structure
```
src/
  main/java
    adventurerguild/
      Adventurer.java
      Adventureguild.java
      Bow.java
      Monster.java
      Quest.java
      Staff.java
      Sword.java
      Weapon.java
    statepackage/
      WeaponLifeCycle.java
      MainState.java
  test/java
    guildtest/
      guildtest.java

resources/
  adventurers.txt
  quests.txt
  monsters.txt

docs/
  class-diagram.png
  state-diagram.png
  sequence-diagram.png
  extended-class-diagram.png
  adventurer-guild.drawio
  uml.puml

README.md
```

---

## ▶️ How to Run
**From IDE (IntelliJ/NetBeans/Eclipse)**
1. Import project
2. Ensure `resources/` is on classpath
3. Run `adventurerguild.Main`

**From Terminal**
```bash
javac -d out $(find src/main/java -name "*.java")
cp -r resources/* out/
java -cp out adventurerguild.Main
```

---

## 🧪 Running Tests (JUnit 4)
From IDE → **Right-click → Run Tests**

or (Maven example if added later):
```bash
mvn -q -Dtest=guildtest.* test
```

---

## 📌 Sample Output (Battle Log)
```
Starting the quest simulation...

Aragorn starts quest: Defeat_the_Goblin_King
Aragorn uses Sword on Goblin_Warrior
Goblin_Warrior attacks back. Aragorn HP: 45
...
Goblin_King is defeated! XP gained.

Quest simulation completed!
```

---

## 🧩 UML Diagrams
Located in `/docs`:

Diagram | Description
---------|------------
`class-diagram.png` | Object structure
`state-diagram.png` | Weapon life cycle
`sequence-diagram.png` | Quest battle sequence
`extended-class-diagram.png` | Detailed hierarchy
`adventurer-guild.drawio` | Source diagram
`uml.puml` | PlantUML source

---

## 🔧 Concepts Demonstrated
- Object-Oriented Design
- Inheritance & Polymorphism
- Encapsulation
- State Pattern
- Composition
- Unit Testing
- File IO (Scanner + Reader)
- Turn-based simulation logic

---

## 🚀 Potential Future Improvements
- Quest reward system (gold / loot)
- Equipment shop + inventory
- Boss mechanics & special skills
- Difficulty scaling
- GUI or Web Front-End (JavaFX or Spring Boot REST API)

---

## 👤 Author
**Toghrul Hasanli**  
Computer Science Student

---

### 🏁 Summary
This project serves as a complete **OOP case study** with clean class structure, polymorphic weapon logic, state-based behavior, and unit-tested combat flow — a good demonstration of practical Object-Oriented programming in Java.

