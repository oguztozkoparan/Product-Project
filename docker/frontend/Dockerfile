FROM node:14.16.1 AS build

# set working directory
WORKDIR /app

# dependencies
COPY package.json ./
RUN npm install

# copy project files
COPY . ./

# run project
RUN npm run build --outputPath=./dist/out

FROM nginx:1.17-alphine
COPY --from=build /app/dist/out/ /usr/share/nginx/html

EXPOSE 4200

ENTRYPOINT [ "nginx", "-g", "daemon off;" ]
