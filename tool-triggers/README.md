# Integrated Java tool triggers

Exactly 12 tool folders are integrated with this Quarkus project.

| # | Folder | Tool(s) | Project input |
|---:|---|---|---|
| 1 | `pmd-lizard` | PMD 7.26 + Lizard | main/test Java source |
| 2 | `jacoco` | JaCoCo 0.8.14 | Maven tests and classes |
| 3 | `pmd` | PMD 7.26 | main Java source |
| 4 | `cpd` | CPD from PMD 7.26 | main/test Java source |
| 5 | `pmd-checkstyle` | PMD 7.26 + Checkstyle | main/test Java source |
| 6 | `spotbugs-findsecbugs` | SpotBugs 4.10.3 + FindSecBugs 1.14 | compiled classes |
| 7 | `dependency-security` | OWASP Dependency-Check 13 + Grype | `pom.xml` and image/filesystem |
| 8 | `jacoco-branch-proxy` | JaCoCo 0.8.14 branch proxy | JaCoCo XML report |
| 9 | `pit` | PIT 1.19.6 | service/resource classes and tests |
| 10 | `diff-cover-jacoco` | diff-cover + JaCoCo 0.8.14 | changed lines and JaCoCo XML |
| 11 | `def-use-jacoco-ast` | custom def-use + JaCoCo + AST | source and coverage XML |
| 12 | `git-pydriller` | Git + PyDriller | repository history |

Modern analyzer releases may require Java 17 even though the application itself
builds and runs on Java 8. Commands are therefore designed for the separate
analysis job in CI.
