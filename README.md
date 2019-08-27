# Milestone-Delete
Used to delete a specific milestones from devnet. It is only good for milestones that are made of a bundle of 2 transactions.
The milestone data is hard coded. One needs to change `milestone index`, `tail`, `head`, `bundle hash`,`tip1` and `tip2`.

### Build
`mvn clean package`

### Usage
`java -jar delete delete-1.0-SNAPSHOT.jar {db path}`


### Docker
```
docker build -t delete-milestone .
docker run -it -v {db path}:/db delete-milestone /db`
```
