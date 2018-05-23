require 'capybara/rspec'
require 'active_record'
require 'yaml'
require 'database_cleaner'

file_path = File.join(File.expand_path("..", File.expand_path(File.dirname(File.dirname(__FILE__)))), "src/main/resources/application.yml")
contents = YAML.load_file(file_path)

ActiveRecord::Base.establish_connection(contents['spring.datasource.url'].sub! 'jdbc:', '')

Dir[File.expand_path('./support/**/*.rb', __dir__)].each {|f| require f}

RSpec.configure do |config|
  config.expect_with :rspec do |expectations|
    expectations.include_chain_clauses_in_custom_matcher_descriptions = true
  end

  config.mock_with :rspec do |mocks|
    mocks.verify_partial_doubles = true
  end

  config.include Capybara::DSL

  config.after(:all) do
    DatabaseCleaner.strategy = :truncation
    DatabaseCleaner.clean
  end
end

Capybara.configure do |config|
  config.run_server = false
	config.default_driver = :selenium_chrome
  config.app_host = 'http://localhost:8081'
end
