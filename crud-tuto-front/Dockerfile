# Stage 0, "build-stage", based on Node.js, to build and compile the frontend
FROM nginx:alpine
COPY dist/crud-tuto-front/ /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
# Expose port 80
# EXPOSE 80