rootProject.name = "co"

include (
    "domain",
    "storage:core-mysql",
    "storage:core-mongo",
    "storage:redis",
    "api",
    "api:admin",
    "common",
    "common:enum",
    "infrastructure"
)