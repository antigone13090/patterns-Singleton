# Pattern Singleton — Explication détaillée

## 1) Intention
Garantir qu’une classe **n’a qu’une seule instance** et fournir un **point d’accès global** à cette instance.

## 2) Quand l’utiliser
- ressource unique : logger, config, pool, driver, cache, “boiler”…
- un état global qui doit être cohérent (et contrôlé)

## 3) Structure (idée)
- Constructeur **privé** : empêche `new`.
- Champ `instance` **statique**.
- Méthode `getInstance()` : retourne toujours la même instance.

## 4) Attention (pièges)
- **Thread-safety** : plusieurs threads peuvent créer plusieurs instances si on fait un lazy singleton naïf.
- **Tests** : un singleton rend les tests plus difficiles (état global).
- **Sérialisation / réflexion** : peuvent casser l’unicité si on ne protège pas (hors scope ici).

## 5) Implémentation du projet
Package :
`src/main/java/headfirst/designpatterns/singleton/`

Classes :
- `ChocolateBoiler` : Singleton + état (`empty`, `boiled`)
- `ChocolateController` : démo console

### 5.1 Pourquoi `volatile` ?
`volatile` empêche certaines réordonnances mémoire qui pourraient exposer une instance partiellement construite.

### 5.2 Double-checked locking
On évite de synchroniser à chaque appel :
1) test rapide si `instance != null`
2) sinon `synchronized` puis re-test
3) création unique

## 6) Lecture de la sortie console
On récupère 2 fois `getInstance()` et on vérifie que :
- l’instance est identique (même référence)
- l’état évolue correctement (fill -> boil -> drain)
