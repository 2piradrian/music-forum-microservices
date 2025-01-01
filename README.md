# Project: Music Forum
# 📁 Collection: Users 


## End-point: Get By ID
### Method: GET
>```
>{{base_url}}/api/users/get-by-id/8fcebeb7-e7fa-49bc-8f7a-6b1290a47180
>```
### Body (**raw**)

```json

```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Auth
### Method: GET
>```
>{{base_url}}/api/users/auth
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "email": "rodriguezcadr@gmail.com",
    "password": "123asfd@#$AA",
    "username": "rodriguezcadr"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Login
### Method: POST
>```
>{{base_url}}/api/users/login
>```
### Body (**raw**)

```json
{
    "email": "2piradrian@gmail.com",
    "password": "MyP@ssword4"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Register
### Method: POST
>```
>{{base_url}}/api/users/register
>```
### Body (**raw**)

```json
{
    "username": "2piradrian",
    "password": "MyP@ssword4",
    "email": "2piradrian@gmail.com"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete
### Method: DELETE
>```
>{{base_url}}/api/users/delete
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body formdata

|Param|value|Type|
|---|---|---|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: Forum 


## End-point: Get By ID
### Method: GET
>```
>{{base_url}}/api/forum/get-by-id/bdd77e84-8cfe-4b99-8176-b083658aa947
>```
### Body (**raw**)

```json

```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get Pages
### Method: GET
>```
>{{base_url}}/api/forum/get-forums?category=SONGS&size=1&page=0
>```
### Body (**raw**)

```json

```

### Query Params

|Param|value|
|---|---|
|category|SONGS|
|size|1|
|page|0|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get Monthly
### Method: GET
>```
>{{base_url}}/api/forum/get-monthly-forums?month=1&year=2025
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json

```

### Query Params

|Param|value|
|---|---|
|month|1|
|year|2025|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Create
### Method: POST
>```
>{{base_url}}/api/forum/create
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "title": "¿Alguien sabe qué acordes lleva 'Us and Them' de Pink Floyd?",
    "content": "Estoy intentando analizar la estructura armónica de 'Us and Them' de *The Dark Side of the Moon*, pero no estoy seguro de qué acordes se utilizan exactamente. ¿Alguien tiene el análisis o los acordes completos de la canción? Me interesa especialmente cómo los acordes contribuyen a la atmósfera melancólica y reflexiva del tema. ¡Cualquier aporte es bienvenido, ya sea un desglose de los acordes, progresiones o incluso ideas sobre su impacto emocional!",
    "category": "SONGS"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Edit
### Method: PATCH
>```
>{{base_url}}/api/forum/edit
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "676e5e6d-b6f8-4ab0-a6bc-f6520e5291e0",
    "title": "¿Alguien sabe qué acordes lleva 'Us and Them' de Pink Floyd?",
    "content": "Estoy intentando analizar la estructura armónica de 'Us and Them' de *The Dark Side of the Moon*, pero no estoy seguro de qué acordes se utilizan exactamente. ¿Alguien tiene el análisis o los acordes completos de la canción? Me interesa especialmente cómo los acordes contribuyen a la atmósfera melancólica y reflexiva del tema.",
    "category": "SONGS"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Toggle Votes
### Method: PATCH
>```
>{{base_url}}/api/forum/toggle-votes
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "bdd77e84-8cfe-4b99-8176-b083658aa947",
    "voteType": "UPVOTE"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete
### Method: DELETE
>```
>{{base_url}}/api/forum/delete
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "e7c1b9a1-bbe0-4085-9f97-44d07b9146a9"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: Comments 


## End-point: Get Pages
### Method: GET
>```
>{{base_url}}/api/comment/get-comments?forumId=bdd77e84-8cfe-4b99-8176-b083658aa947&size=10&page=0
>```
### Body (**raw**)

```json

```

### Query Params

|Param|value|
|---|---|
|forumId|bdd77e84-8cfe-4b99-8176-b083658aa947|
|size|10|
|page|0|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Create
### Method: POST
>```
>{{base_url}}/api/comment/create
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "bdd77e84-8cfe-4b99-8176-b083658aa947",
    "content": "El solo tiene los siguentes acordes: ( Dsus2  Esus2/D  Dm(maj7)  G/D  Dsus2 )x2 ( Bm  Bm/A  D/G  C  Bm  A  Bm  Bm/A  G  C )",
    "replyTo": "9990ab09-a183-4d14-8d04-64988affd4b3" // Optional
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Edit
### Method: PATCH
>```
>{{base_url}}/api/comment/edit
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "commentId": "e7c1b9a1-bbe0-4085-9f97-44d07b9146a9",
    "content": "El solo es: ( Dsus2  Esus2/D  Dm(maj7)  G/D  Dsus2 )x2 ( Bm  Bm/A  D/G  C  Bm  A  Bm  Bm/A  G  C )"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Toggle Votes
### Method: PATCH
>```
>{{base_url}}/api/comment/toggle-votes
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "commentId": "676e5e6d-b6f8-4ab0-a6bc-f6520e5291e0",
    "voteType": "UPVOTE"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete
### Method: DELETE
>```
>{{base_url}}/api/comment/delete
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "commentId": "e7c1b9a1-bbe0-4085-9f97-44d07b9146a9"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: Reports 


## End-point: Monthly Forums
### Method: GET
>```
>{{base_url}}/api/report/forums/monthly?month=1&year=2025
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json

```

### Query Params

|Param|value|
|---|---|
|month|1|
|year|2025|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
