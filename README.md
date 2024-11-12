# Podlodka Java Crew 5th season

Demo application for workshop - Apache EventMesh: How to cook your own Event Mesh

## Instruction

### Apache EventMesh: Event Store

Will be based on top of [Apache RocketMQ](https://github.com/apache/rocketmq)

Launch server:
```shell
docker run -d -p 9876:9876 \
  -v `pwd`/data/namesrv/logs:/root/logs \
  -v `pwd`/data/namesrv/store:/root/store \
  --name rmqnamesrv \
  apache/rocketmq:5.3.1 \
  sh mqnamesrv
```

Launch broker:
```shell
docker run -d -p 10911:10911 -p 10909:10909 \
  -v `pwd`/data/broker/logs:/root/logs \
  -v `pwd`/data/broker/store:/root/store \
  --name rmqbroker \
  --link rmqnamesrv:namesrv \
  -e "NAMESRV_ADDR=namesrv:9876" \
  apache/rocketmq:5.3.1 \
  sh mqbroker -c ../conf/broker.conf
```

See: https://eventmesh.apache.org/docs/instruction/store-with-docker

### Apache EventMesh: Runtime

Launch runtime
```shell
docker run -d \
  --name eventmesh-runtime \
  -p 10000:10000 -p 10105:10105 -p 10205:10205 -p 10106:10106 \
  -v `pwd`/data/eventmesh/conf/eventmesh.properties:/data/app/eventmesh/conf/eventmesh.properties \
  apache/eventmesh:v1.10.0
```

See: https://eventmesh.apache.org/docs/instruction/runtime-with-docker

