## API Endpoints

### 1. Cadastro de Destinos de Viagem:

- **Método:** `POST`  
- **URL:** `/api/destinations`  
- **Body (raw):**

  ```json
  {
    "name": "Nome do destino",
    "location": "Localização do destino",
    "description": "Descrição do destino"
  }
  ```

### 2. Listagem de Destinos de Viagem:

- **Método:** `GET`  
- **URL:** `/api/destinations`  
- **Vai ser retornado os destinos em JSON:**

  ```json
  [
    {
        "id": 1,
        "name": "Paris",
        "location": "France",
        "description": "A cidade das luzes.",
        "averageRating": 8.5,
        "reviewCount": 5,
    },
    {
        "id": 2,
        "name": "Toronto",
        "location": "Canadá",
        "description": "Uma cidade moderna e multicultural."
        "averageRating": 9.0,
        "reviewCount": 12,
    }
  ]
  ```

### 3. Pesquisa de Destinos:

- **Método:** `GET`  
- **URL para buscar destinos pelo nome:** `/api/destinations/search?name=Paris`
- **URL para buscar destinos pelo nome:** `/api/destinations/search?location=França`
- **URL para buscar destinos pelo nome e localização:** `/api/destinations/search?name=Paris&location=França`
- **Vai ser retornado os destinos em JSON:**

  ```json
  [
    {
        "id": 1,
        "name": "Paris",
        "location": "França",
        "description": "A cidade das luzes.",
        "averageRating": 8.5,
        "reviewCount": 5,
    },
  ]
  ```

### 4. Visualização de Informações Detalhadas:

- **Método:** `GET`  
- **URL:** `/api/destinations/{id}`
- **Vai ser retornado o destino em JSON:**

  ```json
  {
    "id": 1,
    "name": "Paris",
    "location": "França",
    "description": "A cidade das luzes.",
    "averageRating": 8.5,
    "reviewCount": 5,
  }
  ```

### 5. Avaliação de Destino de Viagens:

- **Método:** `GET`  
- **URL:** `/api/destinations/{id}/rate?rating=8`
- **Apenas notas de 1 a 10.**
- **Vai ser retornado o destino com a nova média calculada:**

  ```json
  {
    "id": 1,
    "name": "Paris",
    "location": "França",
    "description": "A cidade das luzes.",
    "averageRating": 8.0,
    "reviewCount": 2,
  }
  ```

### 6. Exclusão de Destinos de Viagem:

- **Método:** `DELETE`  
- **URL:** `/api/destinations/{id}`
