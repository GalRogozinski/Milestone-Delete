# Milestone-Delete
Used to delete a specific milestone from devnet. It is only good for milestones that are made of a bundle of 2 transactions.
The milestone data is hard coded. One needs to change `hash1`, `hash2` (tail and head of the milestone bundle) and `milestoneIndex`.

### Build
`mvn clean package`

### Usage
`java -jar delete delete-1.0-SNAPSHOT.jar {db path}`


### Docker
```
docker build -t delete-milestone .
docker run -it -v {db path}:/db {image_name} /db`
```
