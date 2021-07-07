val finalizer = tasks.register("finalizer") {
    doLast {
        println("Running finalizer task.")
    }
}

val task = tasks.register("task") {
    finalizedBy(finalizer)
    doLast {
        println("Running task.")
        throw RuntimeException("Task failed")
    }
}

if (hasProperty("add-dependency")) {
    finalizer.configure {
        dependsOn(task)
    }
}
