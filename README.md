# Singleton (Head First Design Patterns) — Projet IntelliJ/Gradle

## Objectif
Illustrer le **pattern Singleton** (chapitre “Singleton”) avec l’exemple classique **Chocolate Boiler**.

## Problème
On veut **une seule instance** partagée (ex: une chaudière unique).  
Si plusieurs instances existent, on peut :
- remplir/vider plusieurs fois
- casser la logique métier
- avoir des états incohérents

## Solution (Singleton)
- constructeur **privé**
- instance unique **statique**
- méthode `getInstance()` pour accéder à l’unique instance
- version **thread-safe** (lazy) via *double-checked locking* + `volatile`

## Exécuter
```bash
./gradlew run
```

## Documentation
- `docs/SINGLETON.md`
