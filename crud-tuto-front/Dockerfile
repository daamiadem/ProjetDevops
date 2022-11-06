FROM node:14.15.0
WORKDIR /app
COPY ["package.json", "package-lock.json", "./"]
RUN npm install --legacy-peer-deps
COPY . /app
ARG configuration=production
RUN npm run ng build -- --output-path=dist --configuration=$ENVIROMENT --verbose

# Stage 2
FROM nginx:latest
COPY --from=0 /app/dist/ /usr/share/nginx/html
# Expose port 80
EXPOSE 80