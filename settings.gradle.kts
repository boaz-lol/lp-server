rootProject.name = "co"

include (
    "domain",
    "storage:core-mysql",
    "storage:core-mongo",
    "api",
    "api:admin",
    "common",
    "common:enum",
    "infrastructure",
    "infrastructure:kafka"
)