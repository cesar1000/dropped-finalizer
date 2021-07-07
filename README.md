# Adding a task dependency removes a finalizer dependency

This repros a bug where adding a task dependency of F to A removes F as a finalizer to A.

Running a build where F is a finalizer of A runs F even if A fails:

```
./gradlew :task
```

However, adding a task dependency from F to A removes the finalizer dependency:

```
./gradlew :task -Padd-dependency
```
