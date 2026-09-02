```bash
docker run -it --rm --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres pgvector/pgvector:pg18
```
docker run -d --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=ai-db pgvector/pgvector:pg18

// promp use to generate pdf file
Prepare data 100 of IT Courses include course name,  price description, price discount in paragraph.
now take this data and prepare pdf without number put paragraph itself.
include company information that provide the courses.
Trainer name Shoaib Hasan
Company name Iru Institute of technology

Note : docker compose not used