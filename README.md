## Code challenge test
This project is an API Rest code challenge.

### First steps:
- Set the client_secret and client_id  in application.properties before start the app.
- Make sure the database connection parameters are ok.


#### Get track by ISRC

**URL** : `/codechallenge/track/{isrc}`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

## Success Response

**Code** : `200 OK`

**Content examples**

```json
{
    "status": 200,
    "data": [{
            "isrc": "USSM19504584",
            "name": "Orchard House (Main Title) - Instrumental",
            "duration_ms": 205626,
            "explicit": false   
    }]
}
```
For an ISRC that does not exist, the response will be : 
```json
{
    "status": 200,
    "data": []
}
```

#### Create track by ISRC

**URL** : `/codechallenge/track/{isrc}`

**Method** : `POST`

**Auth required** : NO

**Permissions required** : None

#### Success Response

**Code** : `200 OK`

**Content examples**

```json
{
    "status": 200,
    "data": {
            "isrc": "USSM19504584",
            "name": "Orchard House (Main Title) - Instrumental",
            "duration_ms": 205626,
            "explicit": false   
    }
}
```
If the track it has been created before, the response will be an error: 

#### Error Response

**Code** : `400 Bad Request`

**Content examples**

```json
{
    "status": 400,
    "message": "Track USNLR1400628 Already exists"
}
```

In any case of internal server error the response will be : 

**Code** : `500 Internal Server error`

**Content examples**

```json
{
    "status": 500,
    "message": "Error cause message"
}
```
