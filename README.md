# Podlodka Java Crew 5th season

Demo application for workshop - Apache EventMesh: How to cook your own Event Mesh

## Instruction

### Apache EventMesh: Runtime

Launch runtime
```shell
docker run -d \
  --name eventmesh-runtime \
  -p 10000:10000 -p 10105:10105 -p 10205:10205 -p 10106:10106 \
  -v `pwd`/data/eventmesh/conf/eventmesh.properties:/data/app/eventmesh/conf/eventmesh.properties \
  -v `pwd`/data/eventmesh/logs:/data/app/eventmesh/logs \
  apache/eventmesh:v1.10.0
```

See: https://eventmesh.apache.org/docs/instruction/runtime-with-docker


## Documentation

- [Apache EventMesh - Type of Message](https://eventmesh.apache.org/docs/design-document/event-handling-and-integration/runtime-protocol#type-of-message)
- [Apache EventMesh - Event Bridge](https://eventmesh.apache.org/docs/design-document/event-handling-and-integration/event-bridge/)
- [Apache EventMesh - EventMesh Workflow](https://eventmesh.apache.org/docs/design-document/event-handling-and-integration/workflow/)
- [Apache EventMesh - EventMesh Runtime Quick Start](https://eventmesh.apache.org/docs/instruction/runtime/)