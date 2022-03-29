FROM node:14.16.1-alpine AS build

# set working directory
RUN mkdir -p /app
WORKDIR /app

# dependencies
COPY ./package.json /app
RUN npm install

COPY . /app

# run project
RUN npm run build --prod


FROM nginx:1.17.0-alpine
COPY --from=build /dist /usr/share/nginx/html

EXPOSE 4200

ENTRYPOINT [ "nginx", "-g", "daemon off;" ]
