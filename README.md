





#This builds the native image inside a container, so you don't need GraalVM installed locally:
mvn clean package -Dquarkus.package.type=native -Dquarkus.native.container-build=true


build and push to Nexus:
mvn clean package \
  -Dquarkus.package.type=native \
  -Dquarkus.native.container-build=true \
  -Dquarkus.container-image.build=true \
  -Dquarkus.container-image.push=true \
  -Dquarkus.container-image.registry=registry.local.mikecarr.net:5001 \
  -Dquarkus.container-image.group=mcarr \
  -Dquarkus.container-image.name=hello-world-quarkus \
  -Dquarkus.container-image.tag=1.0.5-native \
  -Dquarkus.jib.platforms=linux/amd64 \
  -Dquarkus.container-image.insecure=true \
  
OR
Or Use SDKMAN (Easier):
# Install SDKMAN
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Install GraalVM
sdk install java 17.0.9-graalce
sdk use java 17.0.9-graalce

# Install native-image
gu install native-image


----------------------

docker push nexus.local.mikecarr.net:5001/mcarr/hello-world-quarkus:1.0.0-SNAPSHOT


docker run -it mcarr/hello-world-quarkus:1.0.0-SNAPSHOT





# SSH into your Docker server (10.0.1.201)
ssh mcarr@10.0.1.201

# Install Tailscale
curl -fsSL https://tailscale.com/install.sh | sh

# Start Tailscale (you'll need to authenticate in browser)
sudo tailscale up

# Get your Tailscale IP address
tailscale ip -4
# Example output: 100.64.1.5