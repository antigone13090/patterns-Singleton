#!/usr/bin/env sh
# Minimal Gradle wrapper script placeholder.
# If gradle-wrapper.jar is missing, copy gradle/ and gradlew* from a working project (ex: strategy).
DIR="$(cd "$(dirname "$0")" && pwd)"
exec gradle "$@"
