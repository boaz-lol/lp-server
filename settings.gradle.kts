rootProject.name = "co"

include (
    "domain",
    "storage:core-mysql",
    "api",
    "api:admin",
    "common",
    "common:enum",
    "infrastructure"
)