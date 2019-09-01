-- To create local user for memo (use this approach only for development environment)
CREATE USER 'memouser'@'localhost' IDENTIFIED BY '$2y$12$h43/zisIZoWpmIDucvObzO/OsnMKMJqPjifv3dfJ3yHoSwDPDrMK';
CREATE DATABASE memorize;
GRANT ALL PRIVILEGES ON memorize.* TO 'memouser'@'localhost';