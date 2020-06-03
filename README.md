## 1. configure IAP in:
https://console.cloud.google.com/projectselector2/security/iap?supportedpurview=project
## 2. enable IAP API
## 3. configure application properties:
# spring.cloud.gcp.security.iap.audience=[AUD_OBTAINED], obtained when enable IAP for your project
# spring.cloud.gcp.datastore.namespace = [NAMESPACE], datastore namspace
