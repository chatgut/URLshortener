URL Shortener Service 2024

This project provides a microservice for generating shortened URLs from long URLs. It also allows retrieving the original URL from a shortened one.
How to Run

    Clone the Repository
    Download the project from the repository (replace <your-repo> with the correct URL):

git clone <your-repo>
cd URLShortenerService2024

Start the Services with Docker Compose
Build and run the services using Docker Compose:

    docker-compose up --build

    This will launch two containers:
        url_shortener: The main URL shortener service running on port 8080.
        db: A MongoDB database for storing URL mappings.

How to Test
1. Create a Shortened URL

Endpoint:
POST http://localhost:8080/api/v1/urls/shorten

Request Body:

{
  "originalUrl": "https://www.example.com"
}

Response:

{
  "shortenedUrl": "xyz12345"
}

2. Retrieve the Original URL

Endpoint:
GET http://localhost:8080/api/v1/urls/{shortenedUrl}

For example, if the shortened URL is abc12345, you can access:
http://localhost:8080/api/v1/urls/abc12345

Response:
The original URL (e.g., https://www.example.com) will be returned as plain text.
Stopping the Services

To stop and remove the running containers, execute:

docker-compose down

This guide outlines the steps to deploy and interact with the URL shortener microservice.
