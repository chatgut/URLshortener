**URL Shortener Microservice**

This microservice provides functionality to generate shortened URLs and resolve them back to their original URLs. It is built using Spring Boot and uses MongoDB as its database.

**How to Run**

    Clone the repository:

git clone https://github.com/chatgut/URLshortener.git
cd URLshortener  

Build and run the services using Docker Compose:

    docker-compose up --build  

    This will start two services:
        url_shortener: The URL shortener service available on port 8080.
        mongo: The MongoDB database for storing URL mappings.

**Testing the Service**

1. Shorten a URL

Send a POST request to shorten a long URL:

Endpoint:
POST http://localhost:8080/api/v1/urls/shorten

Request Body:

{  
  "originalUrl": "https://www.example.com"  
}  

Response Example:

{  
  "shortenedUrl": "abcd1234"  
}  

2. Resolve a Shortened URL

Use a GET request to retrieve the original URL:

Endpoint:
GET http://localhost:8080/api/v1/urls/{shortenedUrl}

Replace {shortenedUrl} with the value returned from the POST request.

Example:
GET http://localhost:8080/api/v1/urls/abcd1234

Response Example:
The original URL (e.g., https://www.example.com) will be returned as plain text.
Notes

    Ensure Docker is installed and running on your system before starting the services.
    MongoDB data is stored in a container volume, so it persists between container restarts.

This microservice is ready for deployment and horizontal scaling.
