const PROXY_CONFIG=[
  {
    context: ['/usuario'],
    target: 'http://localhost:8080',
    secure: false,
    loglevel: 'debug'
  }
];

module.exports = PROXY_CONFIG;
