FROM node:14.16.1-alpine AS build

# set working directory
RUN mkdir -p /app
WORKDIR /app

# dependencies
COPY ./frontend/package.json /app
RUN npm install

COPY ./frontend /app

# run project
RUN npm run build --prod


FROM nginx:1.17.0-alpine
COPY --from=build /app/docs /usr/share/nginx/html

EXPOSE 4200

ENTRYPOINT [ "nginx", "-g", "daemon off;" ]
