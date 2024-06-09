# Git Workflow

This project follows the **Feature Branching Git Workflow** strategy which is a collaborative development approach where
each new feature or task is developed in its own branch before being merged into the main codebase. This strategy helps 
in isolating changes, facilitating parallel development, and maintaining a clean project history.

## Table of Contents

- [Main Branch](#main-branch)
- [Workflow Instructions](#workflow-instructions)
- [Branch Naming Convention](#branch-naming-convention)

---

## Main Branch

The `main` branch serves as the stable production-ready version of the application. To maintain its integrity, direct 
commits and merging are not allowed. Instead, all changes must be made through pull requests with approved by reviewer.

---

## Workflow Instructions

1. **Create a New Branch**:

    - **Start from the Main Branch**: Begin by ensuring you are on the latest version of the main branch.

    ```sh
    git checkout main
    git pull origin main
    ```
   
    - **Create a New Branch**: Create a new branch for your feature or task, using a descriptive name and following 
        the [Branch Naming Convention](#branch-naming-convention).

    ```sh
    git checkout -b <branch-prefix>/<branch-name>
    ```

2. **Work on the New Branch**:

    - **Implement Changes**: Make your changes on the new branch, focusing on the specific feature or task.

    - **Add Changes**: Add changes to the staging area either file by file or all changes at once.

      - To add changes file by file:

      ```sh
      git add <filename>
      ```

      - To add all changes at once:

      ```sh
      git add .
      ```

    - **Commit Regularly**: Commit your changes frequently with clear and descriptive commit messages following the 
        [Git Commit Convention](git-commit-convention.md).

    ```sh
    git commit -m "<git conventional commit message>"
    ```

3. **Push Changes**:

    - **Push to Remote**: Once your new branch is complete, push your new branch to the remote repository.

    ```sh
    git push origin <branch-prefix>/<branch-name>
    ```

4. **Create Pull Request**:

   - **Create Pull Request**: Open a pull request from your new branch to the main branch in the project repository 
       on GitHub.

     - Add title follows this template: `Merge branch '<branch-prefix>/<branch-name>' into 'main'`

     - Assign at least **one reviewer** to review code quality and correctness.

5. **Review and Merge**

   - **Review Pull Request**: Assigned reviewers review the code changes, providing feedback and suggestions.

   - **Address Feedback**: Address any feedback received during the review process and make necessary adjustments to 
       your code.

   - **Merge Pull Request**: Once approved, merge the new branch into the main branch.

   - **Delete Branch**: After merging, delete the merged branch both locally and remotely.

   ```sh
    git checkout main
    git branch -d <branch-prefix>/<branch-name>
    git push origin --delete <branch-prefix>/<branch-name>
   ```

---

## Branch Naming Convention

To create a new branch, it should be structured as follows:

```
<branch-prefix>/<branch-name>
```

- `branch-prefix`: A specific prefix to indicate the type of branch it represents
  - `feature`: Reserved for branches implementing new features or functionalities
  - `fix`: Reserved for branches fixing bugs or resolving issues
  - `docs`: Reserved for branches related to documentation updates
  - `refactor`: Reserved for branches focused on code refactoring or restructuring
- `branch-name`: A brief but descriptive name that clearly conveys the purpose or goal of the branch
  - Use lowercase and hyphen-separated
  - Should not be too long

---