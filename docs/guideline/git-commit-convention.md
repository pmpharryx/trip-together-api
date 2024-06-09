# Git Commit Convention

This project follows the [Conventional Commits](https://www.conventionalcommits.org) specification for commit messages.
This convention helps to maintain consistent and meaningful commit history, which is beneficial for project maintenance 
and versioning.

## Table of Contents

- [Commit Structure](#commit-structure)
- [Commit Types](#commit-types)
- [Commit Scopes](#commit-scopes)
- [Example Commit Messages](#example-commit-messages)

---

## Commit Structure

The commit message should be structured as follows:

```
<type>(<scope>): <subject>
```

- `type`: A type of the change being made
- `scope`: A scope that provides additional context about the change (optional but recommended for clarity)
  - Use noun that represent parts or components in the project
  - Use a single word or a short phrase in kebab case (lowercase words separated by hyphens)
- `subject`: A short summary of the change
  - Start with a non-capitalized verb
  - Use imperative mood in present tense
  - No period at the end

**Note**: Clearly state what the commit does. One atomic action per commit is key; if you find yourself wanting to say 
more than one thing, it's a sign that your commit is too large. Let's break it down!

---

## Commit Types

A list of commit types along with their descriptions which offers a quick reference guide for understanding the purpose 
of each commit type within a project.

|    Type    | Description                                                                    |
|:----------:|--------------------------------------------------------------------------------|
|   `feat`   | Introduces a new feature or functionality                                      |
|   `fix`    | Fixes a bug or issue in the codebase                                           |
|   `docs`   | Adds or updates documentation                                                  |
|  `style`   | Improvements or updates related to code formatting or styling                  |
| `refactor` | Restructuring or optimizing existing code without adding new features or fixes |
|   `perf`   | Enhancements to improve code execution speed or efficiency                     |
|   `test`   | Adds new tests or modifies existing ones                                       |
|  `build`   | Changes related to the build process, such as dependencies or configurations   |
|    `ci`    | Updates or modifications to the continuous integration files or scripts        |
|  `revert`  | Reverts a previous commit                                                      |
|  `chore`   | Other miscellaneous tasks that don't fit into other types                      |

---

## Commit Scopes

A list of predefined commit scopes along with their descriptions used within a project. More scopes can be added as
necessary.

|      Scope      | Description                                                      |
|:---------------:|------------------------------------------------------------------|
|    `readme`     | Changes to the README file                                       |
| `specification` | Changes to technical specifications                              |
|     `data`      | Data related documentation, such as data dictionaries or schemas |
|   `guideline`   | Documentation related to guidelines and workflows                |
|    `design`     | Changes to design documentation or diagrams                      |
|  `dependency`   | Updates or changes to project dependencies                       |
|   `resource`    | Changes to resource files                                        |
|    `config`     | Changes to configuration files and settings                      |
|     `maven`     | Changes related to Maven configuration and scripts               |
|    `docker`     | Changes related to Docker configuration                          |
|     `main`      | Changes to the main application file or entry point              |
|    `common`     | Changes to shared components                                     |
|     `auth`      | Changes to authentication related functionality                  |
|     `user`      | Changes to user related functionality                            |

---

## Example Commit Messages

Here are some example commit messages following the conventional commit specification:

- **Feature Implementation**

  ```
  feat(auth): add sign up controller
  ```

- **Bug Fix**

  ```
  fix(user): correct username validation issue
  ```

- **Documentation Update**

  ```
  docs(readme): update installation guide
  ```

- **Code Style Improvement**

  ```
  style(common): reformat utility classes
  ```

- **Code Refactoring**

  ```
  refactor(main): restructure main application class
  ```

- **Performance Improvement**

  ```
  perf(common): optimize query functions
  ```

- **Adding Tests**

  ```
  test(auth): add service layer tests
  ```

- **Build Process Update**

  ```
  build(maven): update dependency versions
  ```

- **Continuous Integration Update**

  ```
  ci(docker): update build image version
  ```

- **Reverting a Commit**

  ```
  revert(auth): revert sign in functionality
  ```

- **Miscellaneous Task**

  ```
  chore: clean up .gitignore file
  ```

---