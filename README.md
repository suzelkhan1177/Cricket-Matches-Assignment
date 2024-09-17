# Cricket Results API

### Prerequisites
- Java 22 or higher
- Maven (for building the project)
- An IDE or text editor (e.g., IntelliJ IDEA, VSCode)

## Overview

The Cricket Results API is a Spring Boot application that provides endpoints to manage and retrieve cricket match results. This API allows users to fetch the results of cricket matches and integrate this data into various applications.

## API Endpoint

### `GET /cricket/results`

Retrieve the results of cricket matches.

**URL**: `http://localhost:8080/cricket/results`

**Method**: `GET`

**Response**: Returns a JSON object containing the cricket match results.

### Example Request

```bash
curl -X GET http://localhost:8080/cricket/results
